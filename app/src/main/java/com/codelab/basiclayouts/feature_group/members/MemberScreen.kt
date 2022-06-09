package com.codelab.basiclayouts.feature_group.members


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codelab.basiclayouts.R
import com.codelab.basiclayouts.feature_group.GroupViewModel
import com.codelab.basiclayouts.feature_group.component.TopBar
import com.codelab.basiclayouts.feature_group.group_create.UserData
import com.codelab.basiclayouts.ui.theme.Brown400
import com.codelab.basiclayouts.ui.theme.Yellow400

@Composable
fun MemberCard(
    groupViewModel: GroupViewModel,
    memberData: UserData,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        backgroundColor = Yellow400,
        border = BorderStroke(4.dp, Brown400),
        elevation = 8.dp,
        modifier = Modifier
            .width(350.dp)
            .padding(8.dp)
            .clickable {/* TODO */} //進入Profile畫面的Navigation
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.remind),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(2.dp)
                    .align(Alignment.CenterEnd)
                    .height(50.dp)
                    .offset(x = (-16).dp)
                    .clickable { groupViewModel.remind(memberData) }
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(4.dp)
            ) {
                Image(
                    painter = painterResource(memberData.profile),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(60.dp)
                        .padding(4.dp)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(
                        text = memberData.name,
                        style = MaterialTheme.typography.h5
                    )
                    Text(
                        text = "任務完成數: ${memberData.completedTasksNum}",
                        style = MaterialTheme.typography.h6.copy(fontSize = 14.sp)
                    )
                }
            }
        }
    }
}
//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun MemberCardPreview() {
//    FriendlyTheme {
//        MemberCard(MemberData(R.drawable.member_1, 56, "Wu Shang Hong"))
//    }
//}

@Composable
fun MemberList(
    groupViewModel: GroupViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(groupViewModel.memberDataList) { item ->
            MemberCard(
                groupViewModel = groupViewModel,
                memberData = item
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MemberScreenPreview(){
    MemberScreen()
}

@Composable
fun MemberScreen(
    groupViewModel: GroupViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    Box {
        Image(
            painter = painterResource(R.drawable.light_group_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            TopBar(
                onClose = {/* TODO */}, //關閉視窗的navigation
                title = "Members"
            )
            MemberList(groupViewModel)
        }
    }
}

//@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//@Composable
//fun MemberScreenPreview() {
//    FriendlyTheme {
//        MemberScreen()
//    }
//}