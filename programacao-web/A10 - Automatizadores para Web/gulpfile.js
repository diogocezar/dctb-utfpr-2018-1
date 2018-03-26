Gulp = {
	self     : null,
	uglify   : null,
	cssmin   : null,
	init: function(){
		Gulp.self     = require('gulp');
		Gulp.uglify   = require('gulp-uglify');
		Gulp.cssmin   = require('gulp-cssmin');
		Gulp.css();
		Gulp.js();
		Gulp.default();
	},
	css: function(){
		Gulp.self.task('css', function(){
			console.log('[CSS] Minificando Arquivos CSS');
			Gulp.self.src('./css/src/**/*.css')
			.pipe(Gulp.cssmin())
			.pipe(Gulp.self.dest('./css/dist'));
		});
	},
	js: function(){
		Gulp.self.task('js', function(){
			console.log('[JS] Minificando Arquivos JavaScript');
			Gulp.self.src(['./js/src/**/*.js', '!js/dist/**'])
			.pipe(Gulp.uglify())
			.pipe(Gulp.self.dest('./js/dist'))
		});
	},
	default: function(){
		Gulp.self.task('default', ['js', 'css']);
	},
	watch: function(){
		Gulp.self.task('watch', function(){
			Gulp.self.watch('./js/**/*.js', ['js']);
			Gulp.self.watch('./css/src/**', ['css']);
		});
	}
}

Gulp.init();