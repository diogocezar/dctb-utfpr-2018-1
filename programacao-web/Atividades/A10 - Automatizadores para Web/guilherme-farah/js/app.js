const App = {
	vue       : null,
	templates : {},
	configs   : {
		'vueEl' : '#dev-is-selling'
	},
	init : () => {
		App.constructTemplates();
		App.startComponents();
		App.startVue();
	},
	setFancybox: () => {
		$("[data-fancybox]").fancybox({
			infobar    : true,
			closeBtn   : true,
			slideShow  : false,
			fullScreen : false,
			thumbs     : false,
			touch      : true,
			hash       : false,
			buttons : [
			'close'
			]
		});
	},
	constructTemplates: () => {
		let tpl = [];
		tpl.push('<div class="item well" v-bind:class="{selled : !product.active}">');
			tpl.push('<h2>{{product.name}}</h2>');
			tpl.push('<a data-fancybox="gallery" :data-options="formatFancy(product.name, product.price)" :href="product.image"><img class="product-image" :src="product.image"></a>');
			tpl.push('<div class="description" v-for="desc in product.description">');
				tpl.push('<div class="description" v-for="(value, key) in desc">');
					tpl.push('<h1 v-if=\'key == "h1"\'>{{value}}</h1>');
					tpl.push('<h2 v-if=\'key == "h2"\'>{{value}}</h2>');
					tpl.push('<h3 v-if=\'key == "h3"\'>{{value}}</h3>');
					tpl.push('<h4 v-if=\'key == "h4"\'>{{value}}</h4>');
					tpl.push('<p v-if=\'key == "p"\'>{{value}}</p>');
				tpl.push('</div>');
			tpl.push('</div>');
			tpl.push('<h2 class="price">{{ formatNumber(product.price) }}</h2>');
			tpl.push('<a :href="\'mailto:\' + configs.email + \'?subject=\' + makeSubject(configs.subject, product.name) + \'&body=\' + makeBody(configs.bodyMail, product.name, product.price)"><button>Comprar</button></a>');
			tpl.push('<a class="whatsapp" :href="\'whatsapp://send?text=\' + makeBody(configs.bodyWhats, product.name, product.price) + makeSite(configs.url)"><button>WhatsApp</button></a>');
		tpl.push('</div>');
		App.templates.product = tpl;
	},
	startComponents: () => {
		Vue.component('product-item', {
			props: ['product', 'configs'],
			template: App.templates.product.join(''),
			methods: {
				formatNumber: function (value) {
					return value.toLocaleString('pt-BR', {style: 'currency', currency: 'BRL'});
				},
				formatFancy: function (product, price){
					return '{"caption" : "' + product + ' - ' + this.formatNumber(price) + '"}';
				},
				makeSubject: function(subject, name){
					return subject + name;
				},
				makeBody: function(body, name, price){
					return body + name + ' por ' + this.formatNumber(price);
				},
				makeSite: function(site){
					return ' - Acesse aqui: ' + site;
				}
			}
		});
	},
	startVue: () => {
		App.vue = new Vue({
			el : App.configs.vueEl,
			data() {
				return {
					configs  : [],
					products : []
				}
			},
			methods: {
				getDatabase: function(){
					axios.get('./json/database.json').
					then(response => {
						this.products = response.data.products;
						this.configs  = response.data.configs;
						App.vue.setTitlePage();
					});
				},
				setTitlePage: function(){
					document.title = this.configs.title;
				}
			},
			mounted(){
				this.getDatabase();
				setTimeout(function() {
					App.setFancybox();
				}, 500);
			}
		})
	}
};
App.init();