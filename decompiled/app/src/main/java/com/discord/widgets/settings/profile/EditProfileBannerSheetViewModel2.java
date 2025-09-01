package com.discord.widgets.settings.profile;

import com.discord.api.user.UserProfile;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserProfile;
import com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: EditProfileBannerSheetViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$StoreState;", "invoke", "()Lcom/discord/widgets/settings/profile/EditProfileBannerSheetViewModel$StoreState;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.profile.EditProfileBannerSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EditProfileBannerSheetViewModel2 extends Lambda implements Function0<EditProfileBannerSheetViewModel.StoreState> {
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserProfile $storeUserProfile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProfileBannerSheetViewModel2(StoreUser storeUser, StoreUserProfile storeUserProfile) {
        super(0);
        this.$storeUser = storeUser;
        this.$storeUserProfile = storeUserProfile;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EditProfileBannerSheetViewModel.StoreState invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EditProfileBannerSheetViewModel.StoreState invoke() {
        MeUser meSnapshot = this.$storeUser.getMeSnapshot();
        UserProfile userProfile = this.$storeUserProfile.getUserProfile(meSnapshot.getId());
        return new EditProfileBannerSheetViewModel.StoreState(MeUser.INSTANCE.merge(meSnapshot, userProfile.getUser()), userProfile);
    }
}
