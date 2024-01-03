package gmlabs.foresyth.adapters.`in`.web
//
// import jakarta.servlet.http.Cookie
// import jakarta.servlet.http.HttpServletRequest
// import jakarta.servlet.http.HttpServletResponse
// import org.springframework.http.HttpStatus
// import org.springframework.http.ResponseEntity
// import org.springframework.security.authentication.AuthenticationManager
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
// import org.springframework.security.core.AuthenticationException
// import org.springframework.security.core.context.SecurityContextHolder
// import org.springframework.web.bind.annotation.PostMapping
// import org.springframework.web.bind.annotation.RequestBody
// import org.springframework.web.bind.annotation.RestController
//
// // Runs locally on http://localhost:8080/
// @RestController
// class LoginController(val authenticationManager: AuthenticationManager) {
//    @PostMapping("/login")
//    fun login(
//        @RequestBody loginRequest: LoginRequest,
//        request: HttpServletRequest,
//        response: HttpServletResponse,
//    ): ResponseEntity<String> {
//        try {
//            val authenticationRequest =
//                UsernamePasswordAuthenticationToken(
//                    loginRequest.username,
//                    loginRequest.password,
//                )
//            val authentication = authenticationManager.authenticate(authenticationRequest)
//            SecurityContextHolder.getContext().authentication = authentication
//
//            // Create session and set cookie
//            val session = request.getSession(true)
//            response.addCookie(createSessionCookie(session.id))
//
//            return ResponseEntity.ok("Login successful")
//        } catch (ex: AuthenticationException) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed")
//        }
//    }
//
//    private fun createSessionCookie(sessionId: String): Cookie {
//        val cookie = Cookie("SESSIONID", sessionId)
//        cookie.isHttpOnly = true
//        cookie.path = "/"
//        // Set other cookie properties as needed
//        return cookie
//    }
//
//    data class LoginRequest(val username: String, val password: String)
// }
