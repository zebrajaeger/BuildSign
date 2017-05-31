#include <Adafruit_NeoPixel.h>
#include <Wire.h>

#define I2C_ADDRESS 0x12
#define LED_PIN 6
#define MATRIX_COLUMNS 8
#define MATRIX_ROWS 8

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
    uint8_t *from = (uint8_t*)&newMsg;
    uint8_t *to = (uint8_t*)&msg;
    for (uint8_t i = 0; i < sizeof(msg_t); ++i) {
      *from = *to;
      ++from;
      ++to;
    }
    newDataAvailable = false;
  }
  // TODO enable interrupts
}

//------------------------------------------------------------------------------
void setup()
//------------------------------------------------------------------------------
{
  newDataAvailable = false;
  Wire.begin(I2C_ADDRESS);
  Wire.onReceive(receiveEvent);
  Wire.onRequest(requestEvent);
  pixels.begin();
  setColorMatrix();

  id = String("BuildDisplay: v1.0.0 msg(") + String(sizeof(msg_t)) + String(")");
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
  for (uint8_t i = 0; i < MATRIX_COLUMNS * 4; ++i) {
    temp = *ptr;
    *ptr++ = temp * msg.percent_of_previous / 100;
  }

  uint16_t r = 0, g = 0, b = 0, w = 0;
  uint32_t px;

  for (uint8_t i = 0; i < MATRIX_COLUMNS; ++i) {
    uint32_t px = pixels.getPixelColor(i);

    w = (px & 0xff) + msg.offset_w;
    if (msg.random_w) w += random(0, msg.random_w + 1);
    if (w > 255)w = 255;

    px >>= 8;
    b = (px & 0xff) + msg.offset_b;
    if (msg.random_b) b += random(0, msg.random_b + 1);
    if (b > 255)b = 255;

    px >>= 8;
    g = (px & 0xff) + msg.offset_g;
    if (msg.random_g) g += random(0, msg.random_g + 1);
    if (g > 255)g = 255;

    r = (px & 0xff) + msg.offset_r;
    if (msg.random_r) r += random(0, msg.random_r + 1);
    if (r > 255)r = 255;

    pixels.setPixelColor(i, r, g, b, w);
  }

  // set random points
  for (uint8_t i = 0; i < msg.random_point_count; ++i) {
    r = msg.random_point_random_r ? msg.random_point_offset_r + random(0, msg.random_point_random_r + 1) : msg.random_point_offset_r;
    g = msg.random_point_random_g ? msg.random_point_offset_g + random(0, msg.random_point_random_g + 1) : msg.random_point_offset_g;
    b = msg.random_point_random_b ? msg.random_point_offset_b + random(0, msg.random_point_random_b + 1) : msg.random_point_offset_b;
    w = msg.random_point_random_w ? msg.random_point_offset_w + random(0, msg.random_point_random_w + 1) : msg.random_point_offset_w;
    pixels.setPixelColor( random(0, MATRIX_COLUMNS), r, g, b, w);
  }

  pixels.show();
  delay(msg.scroll_delay);
}
