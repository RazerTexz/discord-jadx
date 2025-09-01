package com.discord.widgets.channels.memberlist;

import com.discord.utilities.lazy.memberlist.MemberListRow;
import java.util.Comparator;
import kotlin.Metadata;

/* compiled from: ThreadMemberListItemGenerator.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;", "kotlin.jvm.PlatformType", "o1", "o2", "", "compare", "(Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;Lcom/discord/utilities/lazy/memberlist/MemberListRow$Member;)I", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.channels.memberlist.ThreadMemberListItemGeneratorKt$ALPHABETICAL_COMPARATOR$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ThreadMemberListItemGenerator2<T> implements Comparator<MemberListRow.Member> {
    public static final ThreadMemberListItemGenerator2 INSTANCE = new ThreadMemberListItemGenerator2();

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(MemberListRow.Member member, MemberListRow.Member member2) {
        return member.getName().compareTo(member2.getName());
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(MemberListRow.Member member, MemberListRow.Member member2) {
        return compare2(member, member2);
    }
}
