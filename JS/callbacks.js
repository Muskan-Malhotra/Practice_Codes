

// function callbackFunc(data){
//     console.log("this is a callback function and needs to run: " + data);
//     // return;
// }

// function func(data,callback){
//     console.log("Need to print this data");
//     callback(data);
    
// }

// func("Muskan",callbackFunc);


function callbackFunc(data,error){
    if(error){
        console.log("here")
        return error;
    }else {
        console.log("this is a callback function and needs to run: " + data);
    }
    // return;
}

function func(data,callback){
    if(data){
        console.log("Need to print this data");
        callback(data,null);
        
    } else{
        console.log(callback(null,new Error("Null value encountered!!")));
    }
    
}

func("Muskan",callbackFunc);
func("",callbackFunc);





