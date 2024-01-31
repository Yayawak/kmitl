const screenSize = 
{
  w : 500,
  h : 500
}

function setup() {
  // createCanvas(500, 500)
  createCanvas(screenSize['w'], screenSize['h'])
}

const createLayer = (layer_i, no_nueron) => {
  let offsetX = 130
  let offsetY = 100
  let x = 100 + layer_i * offsetX
  // y =  30;
  let size = 80
  for (let i = 0; i < no_nueron; i++) 
  {
    y = 300 - (offsetY * i)
    // e = ellipse(x, y + offsetX * i, size, size)
    // ellipse(x, y + offsetY * i, size, size)
    // ellipse(x, y * i, size, size)
    ellipse(x, y, size, size)
    // ellipse(x, 30 * -i, size, size)
  }
  // ellipse(x, 40, 80, 80)
}

function draw() {
  // put drawing code here
  background(220);
  // ellipse(50, 50 ,80, 80)
  createLayer(0, 2)
  createLayer(1, 3)
  
}

