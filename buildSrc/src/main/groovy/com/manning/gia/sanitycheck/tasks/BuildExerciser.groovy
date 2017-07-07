package com.manning.gia.sanitycheck.tasks

import groovy.io.FileType
import org.gradle.api.Action
import org.gradle.api.DefaultTask
import org.gradle.api.Task
import org.gradle.api.specs.Spec
import org.gradle.api.tasks.*

import com.manning.gia.sanitycheck.processing.BuildBatchProcessor
import com.manning.gia.sanitycheck.processing.JsonTestSetBuildBatchProcessor

class BuildExerciser extends DefaultTask {
    @InputDirectory
    @Optional
    File rootDir = new File('.')

    @Input
    String gradleVersion

    @TaskAction
    void start() {
        BuildBatchProcessor processor = new JsonTestSetBuildBatchProcessor()
        processor.execute(rootDir, gradleVersion)
    }


}