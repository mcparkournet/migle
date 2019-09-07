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

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.api.tasks.TaskContainer
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.withType
import org.gradle.language.jvm.tasks.ProcessResources
import java.io.Serializable

class PluginInitializer<T : Serializable>(
	private val moduleName: String,
	private val attributesFile: AttributesFile,
	private val attributes: T,
	private val attributesInitializer: AttributesInitializer<T>
) {

	fun initialize(project: Project) {
		initializeAttributes()
		initializeExtensionContainer(project.extensions)
		initializeTaskContainer(project.tasks)
	}

	private fun initializeAttributes() {
		attributesInitializer.initialize(attributes)
	}

	private fun initializeExtensionContainer(extensions: ExtensionContainer) {
		extensions.add("migle$moduleName", attributes)
	}

	private fun initializeTaskContainer(tasks: TaskContainer) {
		val task = createGenerateAttributesFileTask(tasks)
		tasks.withType<ProcessResources> {
			from(task)
		}
	}

	private fun createGenerateAttributesFileTask(tasks: TaskContainer): TaskProvider<Task> {
		return tasks.register("generate${moduleName}AttributesFile") {
			val file = attributesFile.getFile(temporaryDir)
			outputs.file(file)
			doLast {
				attributesFile.write(file, attributes)
			}
		}
	}
}
