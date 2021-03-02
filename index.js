const express = require(`express`)
const app = express()
const bodyParser=require(`body-parser`)

app.use(bodyParser.urlencoded({ extended: true }))
app.use(bodyParser.json())
app.use(bodyParser.raw())

const piglatin=require(`piglatin`)
const translate=require(`translate`)

//all instance variable
const languages = [
    "es", "fr", "ar", "zh", "de", "it", "pt", "ru"
]

//console.log(piglatin("hello, my name is Frank"))





let msg="hello world"
let history=["hello world"]
app.get(`/`,(req,res) =>{
    const { language } = req.query

    console.log(language)
    
    if (language === 'piglatin') {
        if (/^([a-z]|\s)*$/i.test(msg)) {
          res.send(piglatin(msg))
        } else {
          res.status(500).send('error: invalid characeter in message')
        }
      }
    
    
      else if(languages.includes(language)) {
        translate(msg, {
          from: 'en',
          to: language,
          engine: 'libre'
        })
        .then(text => res.send(text))
      }else {
        res.send(msg)
      }
})



app.post("/update-message",(req,res)=>{
    
    const message = req.body.message
    msg = message
    history.push(msg)
    res.send('Updated!')

})

app.get("/languages", (req, res) => {
    res.send('here are the languages you can use: '+languages+", piglatin")
})

app.get("/history", (req, res) => {
    res.send(history)
})

app.listen(3000, ()=>{
    console.log(`App listening whatever at http://localhost:3000`)
})