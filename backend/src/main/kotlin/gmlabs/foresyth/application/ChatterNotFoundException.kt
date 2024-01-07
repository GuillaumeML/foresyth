package gmlabs.foresyth.application

import gmlabs.foresyth.domain.BaseChatterException

class ChatterNotFoundException(private val id: String) : BaseChatterException(message = "$id not found")
