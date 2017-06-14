package com.howell.matt.kotlin.test

import org.slf4j.LoggerFactory


inline fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)
