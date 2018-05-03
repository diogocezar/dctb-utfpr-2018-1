const express = require('express');
const app = express();

app.use((request, response, next) => {
    console.log(request.headers);
    next();
})
app.use((request, response, next) => {
    request.chance = Math.random()
    next();
})
app.get('/', (request, response) => {
    response.json({
        chance: request.chance
    });
})
app.listen(3000);