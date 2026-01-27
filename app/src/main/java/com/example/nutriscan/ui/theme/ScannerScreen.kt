package com.example.nutriscan.ui.theme

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.nutriscan.logic.BarcodeAnalyzer

@Composable
fun ScannerScreen(
    onBarcodeDetected: (String?) -> Unit
) {

    val ctx = LocalContext.current
    val cameraController = remember { LifecycleCameraController(ctx) }
    val lifecycleOwner = LocalLifecycleOwner.current


    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            Toast.makeText(ctx, "Permission accepted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(ctx, "No no no no", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {

        val newAnalyzer = BarcodeAnalyzer(onBarcodeDetected = onBarcodeDetected)

        launcher.launch(android.Manifest.permission.CAMERA)
        cameraController.bindToLifecycle(lifecycleOwner)
        cameraController.cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
        cameraController.setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
        cameraController.setImageAnalysisAnalyzer(ContextCompat.getMainExecutor(ctx), newAnalyzer)

    }


    Card(
        border = BorderStroke(
            1.dp, color = black100
        ), elevation = CardDefaults.cardElevation(4.dp), colors = CardDefaults.cardColors(
            containerColor = MintGreen30
        ), modifier = Modifier.size(
            width = 330.dp, height = 330.dp
        )
    ) {

        AndroidView(
            factory = { ctx ->
                PreviewView(ctx).apply {
                    this.controller = cameraController
                }
            }, modifier = Modifier.fillMaxSize()

        )
    }
    Text(text = "Scanning...", modifier = Modifier.padding(16.dp))

}