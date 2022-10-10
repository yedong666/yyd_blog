import axios from 'axios'

function loginToBack(account, password) {
  axios.get('/login', {
    params: {
      account: account,
      password: password,
    }
  })
    .then(function (response) {
      console.log(response)
    })
    .catch(function (error) {
      console.log(error)
    })
}
