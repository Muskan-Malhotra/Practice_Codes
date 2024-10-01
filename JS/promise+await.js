// let prom = new Promise((resolve,reject) => {
//     setTimeout(()=>{
//         console.log("resolve the promise");
//         resolve();
//     },5000);
// })

async function holdThis(){
    return new Promise((resolve,reject) => {
    setTimeout(()=>{
        console.log("resolve the promise");
        resolve();
    },5000);
})
}

// await holdThis();  // can't use this directly coz it uses await; Await can only be used with an async function 

async function main(){
    console.log("working with promises");  //Line 1
    
    await holdThis(); //Line 2
    
    console.log("I am here"); //Line 3
}

main()

/*
without async and await : Lin1 and Line2 prints and then Line3 prints

with async await
Line1 prints...After 5 secs Line 2 is printed and line3 holds till line 2 gets printed
*/
