package com.oslaman.adhan.ui.places

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.oslaman.adhan.R
import com.oslaman.adhan.ui.theme.AdhanyTheme

@Composable
fun PlacesSearchBar (
    query: String,
    modifier: Modifier = Modifier,
    onQueryChange: (String) -> Unit = {},
    onSubmitClick: () -> Unit = {}
) {
    BasicTextField(
        value = query,
        onValueChange = onQueryChange,
        maxLines = 1,
        textStyle = LocalTextStyle.current,
        modifier = modifier,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions {
            onSubmitClick()
        },
        cursorBrush = SolidColor(LocalContentColor.current),
        decorationBox = { innerTextField ->
            SearchFieldDecorationBox(
                onClearClick = { onQueryChange("") },
                isQueryEmpty = query.isEmpty(),
                innerTextField = innerTextField,
            )
        }
    )
}

@Composable
fun SearchFieldDecorationBox(
    onClearClick: () -> Unit,
    isQueryEmpty: Boolean,
    innerTextField: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchIcon(modifier = Modifier
                .padding(end = 12.dp)
                .size(24.dp))

            Box(modifier = Modifier.weight(1f)) {
                if (isQueryEmpty) {
                    Text(
                        text = stringResource(id = R.string.search_places)
                    )
                }
                innerTextField()
            }

            if (!isQueryEmpty) {
                ClearTextButton(
                    onClick = onClearClick,
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .size(24.dp)
                )
            }
        }
    }
}

@Composable
private fun SearchIcon(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Outlined.Search,
        contentDescription = stringResource(id = R.string.search_places)
    )
}

@Composable
private fun ClearTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Outlined.Clear,
            contentDescription = stringResource(id = R.string.clear_text)
        )
    }
}

@Preview
@Composable
private fun SearchBarPreview() {
    AdhanyTheme {
        PlacesSearchBar(
            query = "Osijek",
            modifier = Modifier.padding(24.dp)
        )
    }
}