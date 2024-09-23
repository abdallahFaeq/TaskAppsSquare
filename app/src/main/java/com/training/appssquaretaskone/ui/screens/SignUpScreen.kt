package com.training.appssquaretaskone.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.training.appssquaretaskone.R
import com.training.appssquaretaskone.composable.ErrorTextComponent
import com.training.appssquaretaskone.composable.HeadLineTextComponent
import com.training.appssquaretaskone.composable.HintTextComponent
import com.training.appssquaretaskone.composable.ImageComponent
import com.training.appssquaretaskone.composable.OutlinedTextFieldComponent
import com.training.appssquaretaskone.utils.DestinationUtils
import com.training.appssquaretaskone.utils.Validation
import com.training.appssquaretaskone.viewmodel.RegisterViewModel
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    navController: NavHostController,
    registerViewModel: RegisterViewModel
) {
    val density = LocalDensity.current.density
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(6.dp * density),
        horizontalAlignment = Alignment.Start
    ) {
        val registerState = registerViewModel.registerState.collectAsState()

        val context = LocalContext.current
        val coroutineScope = rememberCoroutineScope()

        var nameTextState by remember {
            mutableStateOf("")
        }
        var emailTextState by remember {
            mutableStateOf("")
        }
        var passwordTextState by remember {
            mutableStateOf("")
        }
        var passwordVisibleState by remember {
            mutableStateOf(false)
        }
        var confirmPasswordTextState by remember {
            mutableStateOf("")
        }
        var confirmPasswordVisibleState by remember {
            mutableStateOf(false)
        }
        var checkedState by remember {
            mutableStateOf(false)
        }
        var isLoading by remember {
            mutableStateOf(false)
        }
        var hasNameError by remember {
            mutableStateOf(false)
        }
        var hasEmailError by remember {
            mutableStateOf(false)
        }
        var hasPasswordError by remember {
            mutableStateOf(false)
        }
        var hasConfirmedPasswordError by remember {
            mutableStateOf(false)
        }

        Spacer(modifier = Modifier.height(6.dp * density))

        ImageComponent(painter = painterResource(id = R.drawable.sign_up_image))

        Spacer(modifier = Modifier.height(12.dp * density))

        HeadLineTextComponent(text = stringResource(id = R.string.sign_up))
        Spacer(modifier = Modifier.height(1.dp * density))

        HintTextComponent(text = stringResource(id = R.string.guide_text_register))
        Spacer(modifier = Modifier.height(4.dp * density))

        Text(text = stringResource(id = R.string.name))
        Spacer(modifier = Modifier.height(1.dp * density))

        OutlinedTextFieldComponent(
            value = nameTextState,
            onValueChange = {
                nameTextState = it
                hasNameError = Validation.isNameValid(it)
            },
            placeHolderString = stringResource(id = R.string.name),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )
        )
        // display error message
        if (!hasNameError){
            ErrorTextComponent(hintError = stringResource(id = R.string.name_error))
        }

        Spacer(modifier = Modifier.height(4.dp * density))

        Text(text = stringResource(id = R.string.email))

        Spacer(modifier = Modifier.height(1.dp * density))

        OutlinedTextFieldComponent(
            value = emailTextState,
            onValueChange = {
                emailTextState = it
                hasEmailError = Validation.isEmailValid(it)
            },
            placeHolderString = stringResource(id = R.string.email),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Email
            )
        )
        if(!hasEmailError){
            ErrorTextComponent(hintError = stringResource(id = R.string.email_error))
        }

        Spacer(modifier = Modifier.height(4.dp * density))

        Text(text = stringResource(id = R.string.password))
        Spacer(modifier = Modifier.height(1.dp * density))

        OutlinedTextFieldComponent(
            value = passwordTextState,
            onValueChange = {
                passwordTextState = it
                hasPasswordError = Validation.isPasswordValid(it)
            },
            placeHolderString = stringResource(id = R.string.password),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisibleState) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (passwordVisibleState) {
                    R.drawable.ic_hide_password
                } else {
                    R.drawable.ic_eye
                }
                IconButton(onClick = { passwordVisibleState = !passwordVisibleState }) {
                    Icon(imageVector = ImageVector.vectorResource(image), contentDescription = "")
                }
            }
        )
        if (!hasPasswordError){
            ErrorTextComponent(hintError = stringResource(id = R.string.password_error))
        }
        Spacer(modifier = Modifier.height(4.dp * density))

        Text(text = stringResource(id = R.string.confirm_password))
        Spacer(modifier = Modifier.height(1.dp * density))

        OutlinedTextFieldComponent(
            value = confirmPasswordTextState,
            onValueChange = {
                confirmPasswordTextState = it
                hasConfirmedPasswordError = if (passwordTextState.equals(it)) true else false
            },
            placeHolderString = stringResource(id = R.string.confirm_password),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (confirmPasswordVisibleState) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (confirmPasswordVisibleState) {
                    R.drawable.ic_hide_password
                } else {
                    R.drawable.ic_eye
                }
                IconButton(onClick = {
                    confirmPasswordVisibleState = !confirmPasswordVisibleState
                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(image),
                        contentDescription = if (confirmPasswordVisibleState) "Hide password" else "Show password"
                    )
                }
            }
        )
        if (!hasConfirmedPasswordError){
            ErrorTextComponent(hintError = stringResource(id = R.string.confirmed_password_error))
        }
        Spacer(modifier = Modifier.height(4.dp * density))

        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Checkbox(checked = checkedState,
                onCheckedChange = {
                    checkedState = it
                })

                val annotatedString =
                    buildAnnotatedString {
                        append(stringResource(id = R.string.by_signing_up_you_agree))
                        withStyle(
                            style = SpanStyle(colorResource(id = R.color.medium_blue))
                        ) {
                            append(stringResource(id = R.string.terms_of_service))
                        }
                    }

                Text(
                    text = annotatedString,
                    lineHeight = 18.sp
                )
        }
        Spacer(modifier = Modifier.height(10.dp * density))

        Button(
            onClick = {
                isLoading = true
                registerViewModel.registerUser(
                    nameTextState,
                    emailTextState,
                    passwordTextState
                )
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.medium_blue)
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.sign_up),
                modifier = Modifier.padding(8.dp)
            )
        }

        val loginAnnotatedString =
            buildAnnotatedString {
                append(stringResource(id = R.string.already_have_account))
                pushStringAnnotation(tag = "Login", annotation = "Login Screen")
                withStyle(style = SpanStyle(colorResource(id = R.color.medium_blue))) {
                    append(" " + stringResource(id = R.string.login))
                }
                pop()
            }
        Spacer(modifier = Modifier.height(4.dp * density))

        ClickableText(
            text = loginAnnotatedString,
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
            onClick = { offset ->
                loginAnnotatedString
                    .getStringAnnotations(tag = "Login", start = offset, end = offset)
                    .firstOrNull()?.let {
                        navController.navigate(DestinationUtils.LOGIN_SCREEN)
                    }
            })

        if (isLoading) {
            CircularProgressIndicator()
        }

        registerState.value?.let {
            if (it.isSuccess) {
                isLoading = false
                LaunchedEffect(key1 = registerState) {
                    navController
                        .navigate(DestinationUtils.CITIES_SCREEN)
                }
            } else if (it.isFailure) {
                isLoading = false
                coroutineScope.launch {
                    Toast.makeText(
                        context, "Exception: ${it.exceptionOrNull()?.localizedMessage}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }

        DisposableEffect(Unit) {
            onDispose {
                registerViewModel.resetRegisterState()
            }
        }
    }
}