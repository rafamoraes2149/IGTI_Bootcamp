import express from 'express';
import gradesRouter from './routes/grades.js';
//import { promises as fs } from 'fs';
//const { readFile, writeFile } = fs;

global.fileName = 'grades.json';

const app = express();
app.use(express.json());
app.use(express.static('public'));
app.use('/grade', gradesRouter);

app.listen(3000, () => {
  console.log('API Started');
});
