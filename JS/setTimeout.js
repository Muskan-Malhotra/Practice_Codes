function runThis(){
    setTimeout(()=>{
        console.log("setTimeout function")
    },5000);
    
}

function runThat(){
    setTimeout(function(){
        console.log("setTimeout function inside tunThat")
    },6000);
    
}

console.log("Print this")
runThis()
runThat()
console.log("here")