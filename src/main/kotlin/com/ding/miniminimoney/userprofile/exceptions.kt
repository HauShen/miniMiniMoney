package com.ding.miniminimoney.userprofile

class UserNotFoundException(override val message: String): RuntimeException()
class WalletNotCreatedException(override val message: String): RuntimeException()
