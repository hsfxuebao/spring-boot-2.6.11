/*
 * Copyright 2012-2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.testsupport.gradle.testkit;

import java.util.Arrays;
import java.util.List;

import org.gradle.api.JavaVersion;
import org.gradle.util.GradleVersion;

/**
 * Versions of Gradle used for testing.
 *
 * @author Scott Frederick
 */
public final class GradleVersions {

	private GradleVersions() {
	}

	public static List<String> allCompatible() {
		if (isJava18()) {
			return Arrays.asList("7.3.3", "7.4.2", GradleVersion.current().getVersion());
		}
		if (isJava17()) {
			return Arrays.asList("7.2", "7.3.3", "7.4.2", GradleVersion.current().getVersion());
		}
		if (isJava16()) {
			return Arrays.asList("7.0.2", "7.1", "7.2", "7.3.3", "7.4.2", GradleVersion.current().getVersion());
		}
		return Arrays.asList("6.8.3", "6.9.2", "7.0.2", "7.1.1", "7.2", "7.3.3", "7.4.2",
				GradleVersion.current().getVersion());
	}

	public static String minimumCompatible() {
		return allCompatible().get(0);
	}

	private static boolean isJava18() {
		return JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_18);
	}

	private static boolean isJava17() {
		return JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_17);
	}

	private static boolean isJava16() {
		return JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_16);
	}

}
