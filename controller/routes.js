import express from "express"

const router = express.Router()

router.get('/', (req, res) => {
    res.render('login.ejs')
})

router.get('/signup', (req, res) => {
    res.render('signup.ejs')
})

router.post('/home', (req, res) => {
    const email = req.body.email
    const role = req.body.role
    switch (role) {
        case "penguji":
            res.render('dosen/home.ejs', {
                email: email,
                role: role
            })
        case "dosen":
            res.render('dosen/home.ejs', {
                email: email,
                role: role
            })
        case "pembimbing":
            res.render('dosen/home.ejs', {
                email: email,
                role: role
            })
        case "mahasiswa":
            res.render('mahasiswa/home.ejs', {
                email: email,
                role: role
            })
        case "koordinator":
            res.render('koor/home.ejs',{
                email: email,
                role: role
            })
    }
})

router.post('/login', (req, res) => {
    const email = req.body.email
    const pass = req.body.password

    if (pass === 'dosen') {
        res.render('dosen/home.ejs', {
            email: email,
            role: pass
        })
    } else if (pass === 'koordinator') {
        res.render('koor/home.ejs', {
            email: email,
            role: pass
        })
    }
    res.render('mahasiswa/home.ejs', {
        email: email,
        role: pass
    })
})

router.post('/profile', (req, res) => {
    const email = req.body.email
    const role = req.body.role

    res.render('profile.ejs', {
        email: email,
        role: role
    })
})

router.post('/select-penguji', (req, res) => {
    const email = req.body.email
    res.render('dosen/penguji.ejs', {
        email: email,
        role: 'penguji'
    })
})

router.post('/create', (req, res) => {
    const email = req.body.email
    const role = req.body.role

    res.render('koor/create.ejs', {
        email: email,
        role: role,
    })
})
export default router