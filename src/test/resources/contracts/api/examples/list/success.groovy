package contracts.api.examples.list

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return OK"
    request {
        url("/api/examples/list") {
        }
        method GET()
    }
    response {
        status OK()
        headers {
            contentType applicationJson()
        }
        body '''\
            [
                {
                    "id": "1",
                    "value": "example1"
                },
                {
                    "id": "2",
                    "value": "example2"
                }
            ]
        '''
    }
    input {
        triggeredBy('checkSuccess()')
    }
}