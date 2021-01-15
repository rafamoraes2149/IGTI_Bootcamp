import express from 'express';
import { promises as fs } from 'fs';

const { readFile, writeFile } = fs;

const router = express.Router();

router.post('/', async (req, res, next) => {
  try {
    let grade = req.body;
    const data = JSON.parse(await readFile(global.fileName));
    grade = {
      id: data.nextId++,
      student: grade.student,
      subject: grade.subject,
      type: grade.type,
      value: grade.value,
      timestamp: new Date(),
    };
    data.grades.push(grade);

    await writeFile(global.fileName, JSON.stringify(data, null, 2));

    res.send(grade);
  } catch (err) {
    console.log(err);
    next(err);
  }
});

router.put('/:id', async (req, res, next) => {
  try {
    const grade = req.body;
    const data = JSON.parse(await readFile(global.fileName));
    const index = data.grades.findIndex(
      (a) => a.id === parseInt(req.params.id)
    );

    if (index === -1) {
      throw new Error('Registro não encontrado.');
    }

    data.grades[index].student = grade.student;
    data.grades[index].subject = grade.subject;
    data.grades[index].type = grade.type;
    data.grades[index].value = grade.value;
    data.grades[index].timestamp = new Date();

    await writeFile(global.fileName, JSON.stringify(data, null, 2));

    res.send(grade);
  } catch (err) {
    console.log(err);
    next(err);
  }
});

router.delete('/:id', async (req, res, next) => {
  try {
    const data = JSON.parse(await readFile(global.fileName));
    data.grades = data.grades.filter(
      (grade) => grade.id !== parseInt(req.params.id)
    );
    await writeFile(global.fileName, JSON.stringify(data, null, 2));
    res.end();
  } catch (err) {
    console.log(err);
    next(err);
  }
});

router.get('/stud_subj_sum', async (req, res, next) => {
  try {
    const data = JSON.parse(await readFile(global.fileName));
    const student = req.body.student;
    const subject = req.body.subject;
    data.grades = data.grades.filter((g) => {
      return g.student === student && g.subject === subject;
    });
    let sum = 0;
    for (let i in data.grades) {
      sum += parseInt(data.grades[i].value);
    }
    const response = { studend: student, subject: subject, subTotal: sum };
    res.send(response);
  } catch (err) {
    console.log(err);
    next(err);
  }
});

router.get('/subj_type_average', async (req, res, next) => {
  try {
    const data = JSON.parse(await readFile(global.fileName));
    const subject = req.body.subject;
    const type = req.body.type;
    data.grades = data.grades.filter((g) => {
      return g.subject === subject && g.type === type;
    });
    let sum = 0;
    for (let i in data.grades) {
      sum += parseInt(data.grades[i].value);
    }
    const average = sum / data.grades.length;
    const response = {
      subject: subject,
      type: type,
      average: average.toFixed(2),
    };
    res.send(response);
  } catch (err) {
    console.log(err);
    next(err);
  }
});

router.get('/subj_type_top3', async (req, res, next) => {
  try {
    const data = JSON.parse(await readFile(global.fileName));
    const subject = req.body.subject;
    const type = req.body.type;
    data.grades = data.grades
      .filter((g) => {
        return g.subject === subject && g.type === type;
      })
      .sort((a, b) => {
        return b.value - a.value;
      })
      .slice(0, 3);
    const response = {
      subject: subject,
      type: type,
      top3: data.grades,
    };
    res.send(response);
  } catch (err) {
    console.log(err);
    next(err);
  }
});

router.get('/:id', async (req, res, next) => {
  try {
    const data = JSON.parse(await readFile(global.fileName));
    const grade = data.grades.find((g) => g.id === parseInt(req.params.id));
    res.send(grade);
  } catch (err) {
    console.log(err);
    next(err);
  }
});

export default router;
