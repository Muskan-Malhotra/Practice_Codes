let str = "Hippo"
let obj = {}

for (let b of str){
    if(b in obj){
        let val = obj[b]+1;
        obj[b] = val;
    } else{
        obj[b] = 1;
    }
}

console.log(obj);

// console.log(Object.entries(obj));
 for (let char of str){
     if(char === char.toUpperCase()){
         console.log("this is uppercase character: " + char);
     }
 }

/*
{ H: 1, i: 1, p: 2, o: 1 }
this is uppercase character: H
*/