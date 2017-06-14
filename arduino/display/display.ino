#include <Adafruit_NeoPixel.h>
#include <Wire.h>

// pin for neopixel matrix
#define LED_PIN 17

// pins to set i2c address
#define I2C_ADR_PIN_0 2
#define I2C_ADR_PIN_1 3
#define I2C_ADR_PIN_2 4
#define I2C_ADR_PIN_3 5
#define I2C_ADR_PIN_4 6
#define I2C_ADR_PIN_5 7
#define I2C_ADR_PIN_6 8

// neopixel struct
#define MATRIX_COLUMNS 8
#define MATRIX_ROWS 8

typedef struct {
  uint8_t b;
  uint8_t g;
  uint8_t r;
  uint8_t w;
} rgbwpixel_t;

union Pixel {
  uint32_t value;
  uint8_t color[4];
  rgbwpixel_t rgbw;
};

typedef struct {
  uint8_t scroll_delay;
  uint8_t scroll_direction;
  uint8_t percent_of_previous;

  uint8_t offset_r;
  uint8_t offset_g;
  uint8_t offset_b;
  uint8_t offset_w;
  uint8_t random_r;
  uint8_t random_g;
  uint8_t random_b;
  uint8_t random_w;

  uint8_t random_point_count;
  uint8_t random_point_offset_r;
  uint8_t random_point_offset_g;
  uint8_t random_point_offset_b;
  uint8_t random_point_offset_w;
  uint8_t random_point_random_r;
  uint8_t random_point_random_g;
  uint8_t random_point_random_b;
  uint8_t random_point_random_w;
} msg_t;

msg_t newMsg;
volatile bool newDataAvailable;
msg_t msg;
Adafruit_NeoPixel pixels = Adafruit_NeoPixel(64, LED_PIN, NEO_KHZ800 + NEO_GRB);

String id;

void setColorMatrix() {
  /*
    msg.scroll_delay = 75;
    msg.scroll_direction = 0;
    msg.percent_of_previous = 40;
    msg.offset_r = 0;
    msg.offset_g = 0;
    msg.offset_b = 0;
    msg.offset_w = 0;
    msg.random_r = 0;
    msg.random_g = 0;
    msg.random_b = 0;
    msg.random_w = 0;
    msg.random_point_count  = 1;
    msg.random_point_offset_r = 0;
    msg.random_point_offset_g = 0;
    msg.random_point_offset_b = 0;
    msg.random_point_offset_w = 0;
    msg.random_point_random_r = 255;
    msg.random_point_random_g = 255;
    msg.random_point_random_b = 255;
    msg.random_point_random_w = 0;
  */

  msg.scroll_delay = 255;
  msg.scroll_direction = 0;
  msg.percent_of_previous = 25;
  msg.offset_r = 0;
  msg.offset_g = 0;
  msg.offset_b = 0;
  msg.offset_w = 0;
  msg.random_r = 0;
  msg.random_g = 0;
  msg.random_b = 0;
  msg.random_w = 0;
  msg.random_point_count  = 1;
  msg.random_point_offset_r = 0;
  msg.random_point_offset_g = 0;
  msg.random_point_offset_b = 0;
  msg.random_point_offset_w = 0;
  msg.random_point_random_r = 255;
  msg.random_point_random_g = 255;
  msg.random_point_random_b = 100;
  msg.random_point_random_w = 0;

}
//------------------------------------------------------------------------------
void requestEvent()
//------------------------------------------------------------------------------
{
  Wire.write(id.c_str());
}

//------------------------------------------------------------------------------
void receiveEvent(int howMany)
//------------------------------------------------------------------------------
{
  if (howMany == sizeof(msg_t)) {
    uint8_t *buffer = (uint8_t*)&newMsg;
    for (uint8_t i = 0; i < sizeof(msg_t); ++i) {
      *buffer = Wire.read();
      ++buffer;
    }
    newDataAvailable = true;
  }
}

//------------------------------------------------------------------------------
void tryCopyBuffer()
//------------------------------------------------------------------------------
{
  // TODO disable interrupts
  if (newDataAvailable) {
    Serial.println("New Data available");
    memcpy( &msg, &newMsg, sizeof(msg_t) );
    newDataAvailable = false;
  }
  // TODO enable interrupts
}

//------------------------------------------------------------------------------
void setup()
//------------------------------------------------------------------------------
{
  Serial.begin(115200);
  newDataAvailable = false;

  // set all i2c-adr-pins to input
  pinMode(I2C_ADR_PIN_0, INPUT);
  pinMode(I2C_ADR_PIN_1, INPUT);
  pinMode(I2C_ADR_PIN_2, INPUT);
  pinMode(I2C_ADR_PIN_3, INPUT);
  pinMode(I2C_ADR_PIN_4, INPUT);
  pinMode(I2C_ADR_PIN_5, INPUT);
  pinMode(I2C_ADR_PIN_6, INPUT);

  // switch pll-ups on
  digitalWrite(I2C_ADR_PIN_0, HIGH);
  digitalWrite(I2C_ADR_PIN_1, HIGH);
  digitalWrite(I2C_ADR_PIN_2, HIGH);
  digitalWrite(I2C_ADR_PIN_3, HIGH);
  digitalWrite(I2C_ADR_PIN_4, HIGH);
  digitalWrite(I2C_ADR_PIN_5, HIGH);
  digitalWrite(I2C_ADR_PIN_6, HIGH);

  delay(100);

  // read i2c-adr
 uint8_t i2cadr = 0;
 i2cadr |= digitalRead(I2C_ADR_PIN_0); 
 i2cadr |= digitalRead(I2C_ADR_PIN_1) << 1;
 i2cadr |= digitalRead(I2C_ADR_PIN_2) << 2;
 i2cadr |= digitalRead(I2C_ADR_PIN_3) << 3;
 i2cadr |= digitalRead(I2C_ADR_PIN_4) << 4;
 i2cadr |= digitalRead(I2C_ADR_PIN_5) << 5;
 i2cadr |= digitalRead(I2C_ADR_PIN_6) << 6;
  
  Wire.begin(i2cadr);
  Wire.onReceive(receiveEvent);
  Wire.onRequest(requestEvent);
  pixels.begin();
  setColorMatrix();

  id = String("BuildDisplay: v1.0.0 msg(") + String(sizeof(msg_t)) + String(")");  
  Serial.println(id);
  Serial.println("I2C-Address is " + String(i2cadr));
}

//------------------------------------------------------------------------------
void loop()
//------------------------------------------------------------------------------
{
  tryCopyBuffer();

  // scroll down
  for (int8_t r = MATRIX_ROWS - 1; r > 0; --r) {
    for (int8_t c = 0; c < MATRIX_COLUMNS; ++c) {
      pixels.setPixelColor(
        r * MATRIX_COLUMNS + c,
        pixels.getPixelColor((r - 1)*MATRIX_COLUMNS + c) );
    }
  }
  
  // percent of previous
  uint8_t* ptr = pixels.getPixels();
  uint16_t temp;
  Pixel pixel;
  for (uint8_t i = 0; i < MATRIX_COLUMNS; ++i) {
    pixel.value = pixels.getPixelColor(i);
    for (uint8_t j = 0; j < 4; ++j) {
      temp = pixel.color[j];
      temp = (temp * msg.percent_of_previous) / 100;
      pixel.color[j] = temp;
    }
    pixels.setPixelColor(i, pixel.value);
  }

  uint16_t r = 0, g = 0, b = 0, w = 0;
  uint32_t px;

  // set baclground points
  for (uint8_t i = 0; i < MATRIX_COLUMNS; ++i) {
    pixel.value = pixels.getPixelColor(i);

    temp = pixel.rgbw.r;
    temp = temp + msg.offset_r + random(0, msg.random_r + 1);
    if (temp > 255) temp = 255;
    pixel.rgbw.r = temp;

    temp = pixel.rgbw.g;
    temp = temp + msg.offset_g + random(0, msg.random_g + 1);
    if (temp > 255) temp = 255;
    pixel.rgbw.g = temp;

    temp = pixel.rgbw.b;
    temp = temp + msg.offset_b + random(0, msg.random_b + 1);
    if (temp > 255) temp = 255;
    pixel.rgbw.b = temp;

    temp = pixel.rgbw.w;
    temp = temp + msg.offset_w + random(0, msg.random_w + 1);
    if (temp > 255) temp = 255;
    pixel.rgbw.w = temp;

    pixels.setPixelColor(i, pixel.value);
  }

  // set random points
  for (uint8_t i = 0; i < msg.random_point_count; ++i) {
    r = msg.random_point_offset_r + random(0, msg.random_point_random_r + 1);
    g = msg.random_point_offset_g + random(0, msg.random_point_random_g + 1);
    b = msg.random_point_offset_b + random(0, msg.random_point_random_b + 1);
    w = msg.random_point_offset_w + random(0, msg.random_point_random_w + 1);

    pixels.setPixelColor( random(0, MATRIX_COLUMNS), r, g, b, w);
  }

  pixels.show();
  delay(msg.scroll_delay);
}
