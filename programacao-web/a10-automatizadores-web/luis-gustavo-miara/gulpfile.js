Gulp = {
	self: null,
	cssmin: null,
	browserSync: null,
	uglify: null,
	watch: null,
	init: function () {
		Gulp.self = require('gulp');
		Gulp.sass = require('gulp-sass');
		Gulp.cssmin = require('gulp-cssmin');
		Gulp.uglify = require('gulp-uglify');
		Gulp.watch = require('gulp-watch');
		Gulp.default();
		Gulp.css();
		Gulp.js();
		Gulp.watch();
	},
	default: () => {
		Gulp.self.task('default', ['css', 'js', 'watch']);
	},
	css: () => {
		Gulp.self.task('css', function () {
			Gulp.self.src('./assets/css/src/**/*.css')
				.pipe(Gulp.cssmin())
				.pipe(Gulp.self.dest('./assets/css/dist'));
		});
	},
	js: () => {
		Gulp.self.task('js', function () {
			Gulp.self.src('./assets/js/src/**/*.js')
				.pipe(Gulp.uglify())
				.pipe(Gulp.self.dest('./assets/js/dist'));
		});
	},
	watch: ()=>{
		Gulp.self.task('watch', function(){
			Gulp.self.watch('./assets/js/src/**/*.js', ['js']);
			Gulp.self.watch('./assets/css/src/**/*.css', ['css']);
		});
	}
};

Gulp.init();