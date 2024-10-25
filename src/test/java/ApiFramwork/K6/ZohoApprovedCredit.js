import http from 'k6/http';
import { check } from 'k6';

export let options = {
    vus: 1,
    duration: '30s',
};

export default function () {
    const url = 'https://qa-oms.msme.jswone.in/joms/api/credit/internal/v1/getCreditInfoByPan?pan=BNEPR4751B';
    const headers = {
        'Accept': 'application/json, text/plain, */*',
        'Accept-Language': 'en-GB,en-US;q=0.9,en;q=0.8',
        'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJtYWxsZXBhbGx5LnZhcm1hQGpzdy5pbiIsImF1dGgiOiJST0xFX1VTRVIiLCJpYXQiOjE2OTk0MzkyODUsImV4cCI6MTczMDk3NTI4NX0.5maAURb63toVEFeN0v42kjjZtbDhGsrKkT47rGMUR3kIp3XVDo0v9NsN2CDrU7RVE1mBiaWQ4GMiiIcP9gOBfw',
        'Connection': 'keep-alive',
        'Origin': 'https://qa-oms.msme.jswone.in',
        'Referer': 'https://qa-oms.msme.jswone.in/order-list/JOO-S4782PFB?tab=shipments',
        'Content-Type': 'application/json',
    };

    console.log('Making request to: ' + url);

    let response = http.get(url, { headers: headers, timeout: '30s' });


   if (response.status !== 200) {
       console.error(`Request failed. Status: ${response.status}`);
   } else {
       console.log('Response: ' + response.body);
   }

   console.log('Received response with status: ' + response.status);


     console.log('Response: ' + response.body);
     const responseBody = JSON.parse(response.body);


     const jsonFilePath = './response.json';
     writeFileSync(jsonFilePath, JSON.stringify(responseBody, null, 2));
}
