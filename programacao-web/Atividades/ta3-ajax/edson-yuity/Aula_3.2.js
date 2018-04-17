const App = {
	vue: null,
	templates: {},
	configs: {
		'vueEl': '#dev'
	},
	init: () => {
		App.Template();
		App.Componente();
		App.Vue();
	},
	Template: () => {
		let template = [];
		template.push('<div class="item well" v-bind:class="{selled : !product.active}">');
		template.push('<h2>{{product.name}}</h2>');
		template.push('<a data-fancybox="gallery" :data-options="formatFancy(product.name, product.price)" :href="product.image"><img class="product-image" :src="product.image"></a>');
		template.push('<div class="description" v-for="desc in product.description">');
		template.push('<div class="description" v-for="(value, key) in desc">');
		template.push('<h1 v-if=\'key == "h1"\'>{{value}}</h1>');
		template.push('<h2 v-if=\'key == "h2"\'>{{value}}</h2>');
		template.push('<h3 v-if=\'key == "h3"\'>{{value}}</h3>');
		template.push('<h4 v-if=\'key == "h4"\'>{{value}}</h4>');
		template.push('<p v-if=\'key == "p"\'>{{value}}</p>');
		template.push('</div>');
		template.push('</div>');
		template.push('<h2 class="price">{{ formatNumber(product.price) }}</h2>');
		template.push('<a :href="\'mailto:\' + configs.email + \'?subject=\' + makeSubject(configs.subject, product.name) + \'&body=\' + makeBody(configs.bodyMail, product.name, product.price)"><button>Comprar</button></a>');
		template.push('<a class="whatsapp" :href="\'whatsapp://send?text=\' + makeBody(configs.bodyWhats, product.name, product.price) + makeSite(configs.url)"><button>WhatsApp</button></a>');
		template.push('</div>');
		App.templates.product = template;
	},
	Componente: () => {
		Vue.component('product-item', {
			props: ['product', 'configs'],
			template: App.templates.product.join(''),
			methods: {
				formatNumber: function (value) {
					return value.toLocaleString('pt-BR', { style: 'currency', currency: 'BRL' });
				},
				formatFancy: function (product, price) {
					return '{"caption" : "' + product + ' - ' + this.formatNumber(price) + '"}';
				},
				makeSubject: function (subject, name) {
					return subject + name;
				},
				makeBody: function (body, name, price) {
					return body + name + ' por ' + this.formatNumber(price);
				},
				makeSite: function (site) {
					return ' - Acesse aqui: ' + site;
				}
			}
		});
	},
	Vue: () => {
		App.vue = new Vue({
			el: App.configs.vueEl,
			data() {
				return {
					configs: [],
					products: []
				}
			},
			methods: {
				getDatabase: function () {
					axios.get('https://diogocezar.github.io/bazar/json/database.json').
						then(response => {
							this.products = response.data.products;
							this.configs = response.data.configs;
							App.vue.setTitlePage();
						});
				},
				setTitlePage: function () {
					document.title = this.configs.title;
				}
			},
			mounted() {
				this.getDatabase();
				setTimeout(function () {
				}, 500);
			}
		})
	}
};
App.init();

