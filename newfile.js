var i = 0;
var j = 5;

for(i=0; i<5; i++){
    console.log("The value of i is " + i);   
    for(j=5; j>i; j--){
        console.log("The value j is " + j);
    }
}