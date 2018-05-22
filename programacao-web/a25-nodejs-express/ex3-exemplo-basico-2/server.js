const Server = {
    express: null,
    app: null,
    port: null,
    bodyParser: null,
    init: () => {
        Server.express = require('express')
        Server.bodyParser = require('body-parser')
        Server.app = Server.express()
        Server.app.use(Server.bodyParser.json())
        Server.app.use(Server.bodyParser.urlencoded({
            extended: true
        }))
        Server.port = process.env.PORT || 8000
        Server.configuration()
        Server.routes()
    },
    configuration: () => {
        Server.app.listen(Server.port, () => {
            console.log(`Server started at: http://localhost:${Server.port}`)
        });
    },
    routes: () => {
        Server.app.get('/home', (req, res) => {
            res.send('<h1>Bem vindo</h1>')
        })
        Server.app.get('/items', (req, res) => {
            var itens = [{
                    name: 'Coca-cola',
                    price: '2.32',
                    description: 'Just a simple description'
                },
                {
                    name: 'Omo',
                    price: '4.48',
                    description: 'Just a simple description'
                },
                {
                    name: 'Macarrao',
                    price: '1.24',
                    description: 'Just a simple description'
                }
            ];
            res.json(itens)
        })
        Server.app.post('/contact', (req, res) => {
            const name = req.body.name
            const email = req.body.email
            res.send(`<h1>Oi, email: ${email} name: ${name}</h1>`)
        });
    }
}

Server.init();