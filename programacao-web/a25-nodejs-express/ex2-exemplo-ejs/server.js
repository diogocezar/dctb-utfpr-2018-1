const Server = {
	express        : null,
	bodyParser     : null,
	expressLayouts : null,
	app            : null,
	port           : null,
	init: () => {
		Server.express        = require('express');
		Server.bodyParser     = require('body-parser');
		Server.expressLayouts = require('express-ejs-layouts');
		Server.app            = Server.express();
		Server.port           = process.env.PORT || 8000;

		Server.configuration();
		Server.routes();
	},
	configuration: () => {
		Server.app.set('view engine', 'ejs');
		Server.app.use(Server.expressLayouts);
		Server.app.use(Server.bodyParser.urlencoded({ extended: true }));
		Server.app.use(Server.express.static(__dirname + '/public'));
		Server.app.listen(Server.port, () => {
		    console.log(`Server started at: http://localhost:${Server.port}`);
		});
	},
	routes: () => {
		Server.app.get('/', (req, res) => {
			var itens = [{
				name : 'Coca-cola',
				value : '2.32'
			},
			{
				name : 'Omo',
				value : '4.48'
			},
			{
				name : 'Macarrão',
				value : '1.24'
			}];
			res.render('pages/index', {
				itens: itens
			});
		});

		Server.app.post('/data', (req, res) => {
			res.render('pages/return', {
				data: req.body.data
			});
		});
	}
}

Server.init();