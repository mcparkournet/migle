/*
 * MIT License
 *
 * Copyright (c) 2019 MCParkour
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.mcparkour.migle

import com.fasterxml.jackson.databind.ObjectMapper
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.api.tasks.TaskContainer
import org.gradle.kotlin.dsl.withType
import org.gradle.language.jvm.tasks.ProcessResources
import java.io.File

class PluginInitializer(
	project: Project,
	private val attributes: ProjectAttributes,
	private val fileName: String,
	private val moduleName: String,
	private val mapper: ObjectMapper
) {

	init {
		project.initialize()
	}

	private fun Project.initialize() {
		attributes.initialize(this)
		extensions.initialize()
		tasks.initialize()
	}

	private fun ProjectAttributes.initialize(project: Project) = apply {
		name = project.name
		version = project.version.toString()
		description = project.description
	}

	private fun ExtensionContainer.initialize() {
		add("migle$moduleName", attributes)
	}

	private fun TaskContainer.initialize() {
		val generateFileTask = createGenerateAttributesFileTask()
		withType<ProcessResources> {
			from(generateFileTask)
		}
	}

	private fun TaskContainer.createGenerateAttributesFileTask() = register("generate${moduleName}AttributesFile") {
		val file = File(temporaryDir, fileName)
		outputs.file(file)
		doLast {
			mapper.writeValue(file, attributes)
		}
	}
}
