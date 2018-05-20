Gulp = {
  self : null,
  sass : null,
  init:function(){
    Gulp.self = require('gulp');
    Gulp.sass = require('gulp-sass');
    Gulp.scss();
    Gulp.default();
    Gulp.watch();
  },
  scss: function(){
    Gulp.self.task('scss', function(){
			console.log('[SASS] Compilando Arquivos do Sass');
			Gulp.self.src('./SCSS/*.scss')
			.pipe(Gulp.sass())
			.pipe(Gulp.self.dest('./SCSS/css'));
    });
  },
  default: function(){
    Gulp.self.task('default',['scss']);
  },
  watch:  function(){
    Gulp.self.task('sass:watch', function () {
      Gulp.self.watch('./SCSS/*.scss', ['scss']);
    });
  }
};
Gulp.init();