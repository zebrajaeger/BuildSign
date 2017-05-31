#include <Wire.h>

#define I2C_ADDRESS 0x12
#define SERIAL_SPEED 115200

void receiveEvent(int howMany) {
  Serial.print("receiveEvent: ");
  Serial.println(howMany);
}

void requestEvent() {
  //Serial.println("requestEvent");
  Wire.write("foo");
}

void setup() {
  Serial.begin(SERIAL_SPEED);
  
  Wire.begin(I2C_ADDRESS);
  Wire.onReceive(receiveEvent);
  Wire.onRequest(requestEvent);
}

void loop(){
  // nothing to do
}

