package com.ssp.cryptocurencyapp.presentation.coin_details.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import com.ssp.cryptocurencyapp.data.remote.dto.coinDetails.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
) {

    Text(
        text = teamMember.name,
        style = MaterialTheme.typography.headlineMedium
    )
    Spacer(modifier = modifier)

    Text(
        text = teamMember.position,
        style = MaterialTheme.typography.headlineSmall,
        fontStyle = FontStyle.Italic
    )
}