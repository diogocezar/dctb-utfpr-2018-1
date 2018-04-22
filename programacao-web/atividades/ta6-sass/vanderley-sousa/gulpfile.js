Gulp = {
    self: null,
    scss: null,
    init: function () {
        Gulp.self = require('gulp');
        Gulp.sass = require('gulp-sass');
        Gulp.scss();
        Gulp.default();
    },
    default: function () {
        Gulp.self.task('default', ['scss']);
    },
    scss: function(){
		Gulp.self.task('scss', function(){
			Gulp.self.src('./sass/**/*.scss')
			.pipe(Gulp.sass())
			.pipe(Gulp.self.dest('./sass/css/'));
		});
	}
}; Gulp.init();
