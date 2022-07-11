var canvas=document.querySelector('canvas');
canvas.width=window.innerWidth;
canvas.height=window.innerHeight;
var c=canvas.getContext('2d');
// c.fillRect(100,100,100,100);
// c.fillRect(400,400,100,100);
// c.fillRect(300,300,100,100);
// c.fillRect(200,200,100,100);
// console.log(canvas.width, canvas.height);
// // c.beginPath();
// // c.arc(300,300,30,0,Math.PI*2);
// // c.strokeStyle="pink";
// // c.stroke();
// // c.beginPath();
// for(let i=0; i<1000;i++){
//     c.beginPath();
//     let x=Math.random()*window.innerHeight;
//     let y=Math.random()*window.innerWidth;
//         let color=getRandomColor();
//     c.arc(x,y,30,0,Math.PI*2);
//     c.strokeStyle=color;
//     c.stroke();
// }
function getRandomColor() {
    const availableCharacters = '0123456789ABCDEF';
    const availableCharacterLength = availableCharacters.length;

    let color = '#';

    for (let i = 0; i < 6; i++) {
      color += availableCharacters[Math.floor(Math.random() * availableCharacterLength)];
    }

    return color;
}
    function Circle(x,y,dx,dy,rad){
        this.x=x;
        this.y=y;
        this.dx=dx;
        this.dy=dy;
        this.rad=rad;
        this.draw=function(){
            c.beginPath();
            c.arc(this.x,this.y,this.rad,0,Math.PI*2,false);
            c.strokeStyle="white";
            c.stroke();
            c.fillStyle=getRandomColor();
            c.fill();
            console.log('asdf');
        }
        this.update=function(){
            if(this.x+this.rad>innerWidth ||this.x-this.rad<0){
                this.dx=-this.dx;
            }
            if(this.y+this.rad>innerHeight||this.y-this.rad<0){
            this. dy=-this.dy;
            }
            this.x+=this.dx;
            this.y+=this.dy;
            this.draw();
        }
    }
    var circleArray=[];
    for(let i=0;i<100;i++){
        let rad=30;
        let x=Math.random()*(innerWidth -2*rad)+rad;
        var y=Math.random()*(innerHeight-2*rad)+rad;
        let dx=(Math.random()-0.5)*10;
        let dy=(Math.random()-0.5)*10 ;
        // let dx=1;
        // var dy=1 ;
        circleArray.push(new Circle(x,y,dx,dy,rad))   ;   
    }
    
    function animate(){
        requestAnimationFrame(animate);
        c.clearRect(0,0,innerWidth,innerHeight);
        for(let i=0;i<circleArray.length;i++){
            circleArray[i].update();
        }
    }
    animate();