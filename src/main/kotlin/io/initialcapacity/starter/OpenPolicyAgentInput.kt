package io.initialcapacity.starter

import com.fasterxml.jackson.annotation.JsonRootName

@JsonRootName(value = "input")
data class OpenPolicyAgentInput(val principals: List<String>, val method: String, val path: String)