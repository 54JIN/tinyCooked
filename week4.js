const express = require(`express`) 
const app = express() 
const bodyParser=require(`body-parser`) 
app.use(bodyParser.urlencoded({ extended: true })) 
app.use(bodyParser.json()) 
app.use(bodyParser.raw()) 

const piglatin=require(`piglatin`) 
const translate=require(`translate`) 

//console.log(piglatin("hello, my name is Frank"))

let msg="hello world" 
let tweets=[]

class UUID{
    constructor(){
        this.id=0
        return ()=>this.increment()
    }

    increment(){
        return String(this.id++)
    }
}
const uuid=new UUID()


app.get(`/`,(req,res) =>{ 
    const {language}=req.body 
    console.log(language) 
    /* 
    if(language === "piglatin"){ 
        res.send(piglatin(msg)) 
    } 
    else{ 
        res.send(msg) 
    }
    */ 
    translate(msg,{ 
        from:"en", 
        to: language, 
        engine:"libre" 

    }) 
    .then(text=>res.send(text)) 

}) 

 
app.post("/update-message",(req,res)=>{ 

    const message= req.body.message 
    //const {message} = req.body 
    msg=message 
    res.send("works new code : "+msg) 

})


// 
//
//tweeting section
app.post(`/tweets`,(req,res)=>{
    const {message, handle}=req.body

    if([message,handle].includes(undefined)){
        res.status(400).send(`Error: message and handle required`)
        return
    }

    if(message.length <2 || message.length > 280){
        res.status(400).send(`Error: too long or too short tweet`)
        return
    }
    
    console.log(req)
    const tweet={
        message,
        handle,
        createAt:new Date(),
        updatedAt: new Date(),
        id:uuid(),
        likes:0
    }
    tweets.unshift(tweet)
    res.send("created new post")
})
 
app.get(`/tweet`,(req,res)=>{
    res.send(tweets)
})

app.get(`/profile`,(req,res)=>{
    const name=req.query.user
})

app.listen(3000, ()=>{ 

    console.log(`App listening whatever at http://localhost:3000`) 

}) 

 