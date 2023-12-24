
#define TotalMenu 5
#define button1 2

// * --------------------------------------------- Menu Section ------------------------------------------
// WidgetLED led_1(V3);
// WidgetLED led_2(V4);
// int pinvalue = 4;
// int pinvalue1 = 0;
// int pinvalue2 = 2;






class Menu {
private:
    bool isExecuting = false;
    bool isEnd = false;

public:
    int menuIndex;
    char *menuName;
    int pinNumber;

    Menu() 
    {}

    Menu(int menuIndex, char* name, int pinNo) 
        : menuIndex(menuIndex), menuName(name), pinNumber(pinNo)
    { 

    }

    void execute() {
        isExecuting = true;
        // isExecuting = false;
    }

    bool getExecuting() { 
        return isExecuting; 
    }

    void endExecution() {
        isExecuting = true;
        isEnd = true; 
    }

    bool getIsEnd() {
        return isEnd; 
    }

    void print() {
        Serial.println("Menu [" + String(menuIndex) + "] " + "Name = " + String(menuName));
    }
};

// * --------------------------------------------- Queue Section ------------------------------------------

template<class T>
class Queue {
  private:
    int _front, _back, _count;
    T *_data;
    int _maxitems;
  public:
    Queue(int maxitems = 256) {
      _front = 0;
      _back = 0;
      _count = 0;
      _maxitems = maxitems;
      _data = new T[maxitems + 1];
    }
    ~Queue() {
      delete[] _data;
    }
    inline int count();
    inline int front();
    inline int back();
    inline int empty();
    void push(const T &item);
    T peek();
    T pop();
    void clear();
};

template<class T>
inline int Queue<T>::count()
{
  return _count;
}

template<class T>
inline int Queue<T>::empty()
{
  return count() > 0 ? 0 : 1;
}

template<class T>
inline int Queue<T>::front()
{
  return _front;
}

template<class T>
inline int Queue<T>::back()
{
  return _back;
}

template<class T>
void Queue<T>::push(const T &item)
{
  if(_count < _maxitems) { // Drops out when full
    _data[_back++]=item;
    ++_count;
    // Check wrap around
    if (_back > _maxitems)
      _back -= (_maxitems + 1);
  }
}

template<class T>
T Queue<T>::pop() {
  if(_count <= 0) return T(); // Returns empty
  else {
    T result = _data[_front];
    _front++;
    --_count;
    // Check wrap around
    if (_front > _maxitems)
      _front -= (_maxitems + 1);
    return result;
  }
}

template<class T>
T Queue<T>::peek() {
  if(_count <= 0) return T(); // Returns empty
  else return _data[_front];
}

template<class T>
void Queue<T>::clear()
{
  _front = _back;
  _count = 0;
}


// * --------------------------------------------- Integration Section ------------------------------------------

Menu menus[TotalMenu];
Queue<Menu> commandQueue;

void showQ();
void raiseOrder() {
  for (int index = 0; index < TotalMenu; index++) {
      // if (/* read data from click button on blynk */ false) {
      if (digitalRead(menus[index].pinNumber) == HIGH)
      {
          commandQueue.push(menus[index]);
          delay(1000); // cant not push this button too fast !
          digitalWrite(menus[index].pinNumber, LOW);
          showQ();
      }
  }
}

    Queue<Menu> qq;
    int i = 1;

    // Serial.println("\n");
    while (!commandQueue.empty()) {
        Menu cmd = commandQueue.peek();
        Serial.print("Q index = ");
        Serial.println(i);
        cmd.print();
        commandQueue.pop();
        qq.push(cmd);
        i++;
        Serial.println("");
    }
    // Serial.println("\n");
    commandQueue = qq;
}


void queueMonitor() {
    // while (1) {
  if (!commandQueue.empty()) {
      Menu activeCommand = commandQueue.peek();
      if (activeCommand.getExecuting() == false) {
          activeCommand.execute();
      }
      if (activeCommand.getIsEnd()) {
          Serial.println("\n");
          Serial.println("Making new command");
          commandQueue.pop();
      }
  }
}

void setupMenuData() {
  // argument ตัวที่สามคือ pin number
    menus[0] = Menu(0, "water", 1);
    menus[1] = Menu(1, "oil", button1);
    menus[2] = Menu(2, "coke", 3);
    menus[3] = Menu(3, "malakor", 4);
    menus[4] = Menu(4, "dadala", 5);
}


// * ---------------------------------------------- Legacy Code --------------------------




// void encoder(){
//   static int lastA = 0;
//   int currentA = digitalRead(PIN_ENCODE_OUT_A_AXIS_X);
//   int currentB = digitalRead(PIN_ENCODE_OUT_B_AXIS_X);
  
//   if ((lastA == LOW) && (currentA == HIGH)) {
//     if (currentB == LOW) {counter++;} 
//     else {counter--;}
//   }
  
//   lastA = currentA;
// }


void setup()
{
  Serial.begin(115200);

  Serial.println(" - Starting"); 
  pinMode(button1, INPUT);
  setupMenuData();

}




void loop ()
{
  

  if (digitalRead(button1) == HIGH)
  {
    Serial.println("button 1 pressed.");
    digitalWrite(button1, HIGH);
    delay(100);

  }
  else
  {
    digitalWrite(button1, LOW);

    // Serial.println("undo");
  }

  raiseOrder(); ////////////// this is Must be link degital status to Queuing in order 
  queueMonitor();
 
  // if (pinvalue == HIGH and running == false) {
  //   //step == 2 END
  //   //step == 1 forward_axis_y
  //   step[0] = 14;
  //   step[1] = 1;
  //   step[2] = 1;
  //   step[3] = 24;
  //   step[4] = 1;
  //   step[5] = 1;
  //   step[6] = 2;
    
  //   ix_status = 20;
  //   running = true;
  //   led_1.on();
  //   led_2.off();
  //   digitalWrite(relay, HIGH);
  // }
  
  // if (pinvalue1 == HIGH and running == false) {
  //   //step == 2 END
  //   //step == 1 forward_axis_y
  //   step[0] = 34;
  //   step[1] = 1;
  //   step[2] = 44;
  //   step[3] = 1;
  //   step[4] = 54;
  //   step[5] = 1;
  //   step[6] = 65;
  //   step[7] = 1;
  //   step[8] = 2;
  //   ix_status = 20;
  //   running = true;
  //   led_1.on();
  //   led_2.off();
  //   digitalWrite(relay, HIGH);
    

  // }
  // if (pinvalue2 == HIGH and running == false) {
  //   //step == 2 END
  //   //step == 1 forward_axis_y
  //   step[0] = 10;
  //   step[1] = 1;
  //   step[2] = 15;
  //   step[3] = 1;
  //   step[4] = 20;
  //   step[5] = 1;
  //   step[6] = 2;
    
  //   ix_status = 20;
  //   running = true;
  //   led_1.on();
  //   led_2.off();
  //   digitalWrite(relay, HIGH);
  // }
  
/*  if(running == true){
    if (p_meun0 == LOW){}
    else if (p_meun1 == LOW){}
  }

  if (running == false){
    for
      if (meun_ix[]
    }
*/
  }
