import org.springframework.cloud.contract.spec.Contract

import static org.springframework.cloud.contract.spec.internal.HttpMethods.HttpMethod.GET

Contract.make {
    request {
        method GET
        url('/hotels') {
            queryParameters {
                parameter 'location', 'Kraków'
            }
        }
    }
    response {
        headers {
            contentType(applicationJson())
        }
        status 200
        body([availableHotels:
                      [
                              [id: 1, name: 'Sheraton', address: 'ul. Jana Nowaka 1'],
                              [id: 2, name: 'Novotel', address: 'ul. Marii Konopnickej 2']
                      ]
        ])
    }
}