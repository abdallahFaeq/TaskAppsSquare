package com.training.appssquaretaskone.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.training.appssquaretaskone.R

@Composable
fun OutlinedTextFieldComponent(
    value : String,
    onValueChange:(newText:String)->Unit,
    placeHolderString: String,
    keyboardOptions: KeyboardOptions,
    modifier : Modifier? = null,
    isError:Boolean?=null,

    visualTransformation:VisualTransformation?=null,
    trailingIcon : @Composable (()->Unit)?=null
){
   OutlinedTextField(value = value,
       onValueChange = onValueChange,
       placeholder = {
           Text(text = placeHolderString)
       },modifier = modifier?:Modifier.fillMaxWidth(),
       keyboardOptions = keyboardOptions,
       // constant
       colors = TextFieldDefaults.colors(
           unfocusedContainerColor = Color.White,
           unfocusedIndicatorColor = Color.LightGray
       ),isError = isError?:false,
       // constant
       shape = RoundedCornerShape(12.dp),
       // constant
       textStyle = TextStyle(
           color = colorResource(id = R.color.gray),
           fontSize = 16.sp,
           fontWeight = FontWeight(400)
       ),
       visualTransformation = visualTransformation?: VisualTransformation.None,
       trailingIcon = trailingIcon
       )
}