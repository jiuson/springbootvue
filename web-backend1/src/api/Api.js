import axios from 'axios';

let baseUrl = 'http://localhost:8080';

export const login = params => {return axios.post(baseUrl + '/login', params).then(res => res.data);};
