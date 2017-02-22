package uk.co.boombastech.kotlinweb.http

import uk.co.boombastech.kotlinweb.http.HttpStatus.ok

class DataResponse(val data: Any, httpStatus: HttpStatus = ok) : Response(httpStatus)