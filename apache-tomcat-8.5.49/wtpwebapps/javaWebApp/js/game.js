/*
JS para el mitico juego del Arkanoid 
*/


console.trace('Comenzamos a jugar');

//****************************************************************VARIABLES*********************************************************************/


var canvas = document.getElementById("myCanvas");
var ctx = canvas.getContext("2d");
//X & Y Axis
var x = canvas.width/2;
var y = canvas.height - 30;
var dx = 2;
var dy = -2;
var ballRadius = 10;
var rightPressed = false, leftPressed = false;

//Paddle
var paddleHeight = 10;
var paddleWidth = 75;
var paddleX = (canvas.width-paddleWidth)/2;

//Bricks
var brickRowCount = 3;
var brickColumnCount = 5;
var brickWidth = 75;
var brickHeight = 20;
var brickPadding = 10;
var brickOffsetTop = 30;
var brickOffsetLeft = 30;

//Score
var score = 0;

//Lives
var lives = 3;

//****************************************************************FUNCTIONS*********************************************************************/


//****************************************************************DRAW*BALL****************************************************************** */

function drawBall() {
    ctx.beginPath();
    ctx.arc(x, y, ballRadius, 0, Math.PI*2);
    ctx.fillStyle = "#0095DD";
    ctx.fill();
    ctx.closePath();
}

//****************************************************************DRAWING********************************************************************** */

function draw() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    drawBricks();
    drawBall();
    drawPaddle();
    drawScore();
    drawLives();
    collisionDetection();
    

    if(x + dx > canvas.width-ballRadius || x + dx < ballRadius) {
        dx = -dx;
    }
    if( y + dy < ballRadius) {
        dy = -dy;
    }else if(y + dy > canvas.height-ballRadius) {
        //Golpear la bola con la paleta
        if(x > paddleX && x < paddleX + paddleWidth) {
            dy = -dy;
            dy--;
            dx++;
        }else{
            lives--;
            if(!lives) {
                alert("GAME OVER");
                document.location.reload();
            }
            else {
                x = canvas.width/2;
                y = canvas.height-30;
                dx = 2;
                dy = -2;
                paddleX = (canvas.width-paddleWidth)/2;
            }
        }
    }
    
    //**********************************************************COLLISION******************************************************************* */

    if(rightPressed && paddleX < canvas.width-paddleWidth) {
        paddleX += 10;
    }
    else if(leftPressed && paddleX > 0) {
        paddleX -= 10;
    }
    
    x += dx;
    y += dy;

    requestAnimationFrame(draw);

} //Fin Draw

function collisionDetection() {
    for(c=0; c<brickColumnCount; c++) {
        for(r=0; r<brickRowCount; r++) {
            var b = bricks[c][r];
            if(b.status == 1) {
                if(x > b.x && x < b.x+brickWidth && y > b.y && y < b.y+brickHeight) {
                    dy = -dy;
                    b.status = 0;
                    score++;
                    if(score == brickRowCount*brickColumnCount) {
                        alert("YOU WIN, CONGRATULATIONS!");
                        document.location.reload();
                    }
                }
            }
        }
    }
}

//****************************************************************PADDLE******************************************************************** */

function drawPaddle() {
    ctx.beginPath();
    ctx.rect(paddleX, canvas.height-paddleHeight, paddleWidth, paddleHeight);
    ctx.fillStyle = "#0095DD";
    ctx.fill();
    ctx.closePath();
}


//****************************************************************LIVES********************************************************************* */

function drawLives() {
    ctx.font = "16px Arial";
    ctx.fillStyle = "#0095DD";
    ctx.fillText("Lives: "+lives, canvas.width-65, 20);
}
//****************************************************************BRICKS******************************************************************** */


var bricks = [];

    for(c=0; c<brickColumnCount; c++) {
        bricks[c] = [];
        for(r=0; r<brickRowCount; r++) {
            bricks[c][r] = { x: 0, y: 0, status: 1};
        }
    }


    function drawBricks() {
        for(c=0; c<brickColumnCount; c++) {
            for(r=0; r<brickRowCount; r++) {
                if(bricks[c][r].status == 1) {
                    var brickX = (c*(brickWidth+brickPadding))+brickOffsetLeft;
                    var brickY = (r*(brickHeight+brickPadding))+brickOffsetTop;
                    bricks[c][r].x = brickX;
                    bricks[c][r].y = brickY;
                    ctx.beginPath();
                    ctx.rect(brickX, brickY, brickWidth, brickHeight);
                    ctx.fillStyle = "#0095DD";
                    ctx.fill();
                    ctx.closePath();
                }
            }
        }
    }

// Definir y manejar los eventos ocurridos cuando se pulse
// la flecha izda o la dcha
//****************************************************************EVENTS******************************************************************** */
document.addEventListener("keydown", keyDownHandler, false);
document.addEventListener("keyup", keyUpHandler, false);
document.addEventListener("mousemove", mouseMoveHandler, false);

    //On Key Pressed
    function keyDownHandler(e){
        if(e.keyCode == 39){
            rightPressed = true;
        }
        if(e.keyCode == 37){
            leftPressed = true;
        }

    }

    // On Key Released    
    function keyUpHandler(e) {

        if(e.keyCode == 39) {
            rightPressed = false;
        }
        else if(e.keyCode == 37) {
            leftPressed = false;
        }
    }

    // On Mouse Move
    function mouseMoveHandler(e) {
        var relativeX = e.clientX - canvas.offsetLeft;
        if(relativeX > 0 && relativeX < canvas.width) {
            paddleX = relativeX - paddleWidth/2;
        }
    }

//****************************************************************SCORE*********************************************************************** */

    function drawScore() {
        ctx.font = "16px Arial";
        ctx.fillStyle = "#0095DD";
        ctx.fillText("Score: "+score, 8, 20);
    }


//****************************************************************LAUNCH********************************************************************** */

   draw();


//***********************************************************COMMENTED*CODE******************************************************************** */

//El segundo valor es cuanto va a tardar en volver a llamar al 1er parametro con un valor en ms
//setInterval(draw, 1);

/*
function draw() {
    //console.debug('Dibujar');
    //Clear the canvas before each drawing
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    ctx.beginPath();
    ctx.arc(x, y, 20, 0, Math.PI*2);
    ctx.fillStyle = "green";
    ctx.fill();
    ctx.closePath();

    x+=dx;
    y+=dy;

}*/








/* Dibuar un rectangulo, una pelota y el borde de un bloque
ctx.beginPath();
ctx.rect(20, 40, 50, 50);
ctx.fillStyle = "#FF0000";
ctx.fill();
ctx.closePath();

ctx.beginPath();
ctx.arc(240, 160, 20, 0, Math.PI*2, false);
ctx.fillStyle = "green";
ctx.fill();
ctx.closePath();

ctx.beginPath();
ctx.rect(160, 10, 100, 40);
ctx.strokeStyle = "rgba(0, 0, 255, 0.5)";
ctx.stroke();
ctx.closePath();*/