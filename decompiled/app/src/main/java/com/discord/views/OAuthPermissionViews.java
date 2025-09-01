package com.discord.views;

import android.widget.TextView;
import b.a.i.OauthTokenPermissionListItemBinding;
import com.discord.R;
import com.discord.api.auth.OAuthScope;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: OAuthPermissionViews.kt */
/* loaded from: classes2.dex */
public final class OAuthPermissionViews {

    /* compiled from: OAuthPermissionViews.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0004\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/discord/views/OAuthPermissionViews$InvalidScopeException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "", "scope", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class InvalidScopeException extends IllegalArgumentException {
        private final String scope;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidScopeException(String str) {
            super("invalid scope: " + str);
            Intrinsics3.checkNotNullParameter(str, "scope");
            this.scope = str;
        }

        /* renamed from: a, reason: from getter */
        public final String getScope() {
            return this.scope;
        }
    }

    /* compiled from: OAuthPermissionViews.kt */
    public static final class a extends SimpleRecyclerAdapter.ViewHolder<OAuthScope> {
        public final OauthTokenPermissionListItemBinding a;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(OauthTokenPermissionListItemBinding oauthTokenPermissionListItemBinding) {
            Intrinsics3.checkNotNullParameter(oauthTokenPermissionListItemBinding, "binding");
            TextView textView = oauthTokenPermissionListItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            super(textView);
            this.a = oauthTokenPermissionListItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(OAuthScope oAuthScope) throws InvalidScopeException {
            OAuthScope oAuthScope2 = oAuthScope;
            Intrinsics3.checkNotNullParameter(oAuthScope2, "data");
            TextView textView = this.a.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            OAuthPermissionViews.a(textView, oAuthScope2);
        }
    }

    public static final void a(TextView textView, OAuthScope oAuthScope) throws InvalidScopeException {
        int i;
        Intrinsics3.checkNotNullParameter(textView, "$this$setScopePermissionText");
        Intrinsics3.checkNotNullParameter(oAuthScope, "scope");
        if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Identify.INSTANCE)) {
            i = R.string.scope_identify;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Email.INSTANCE)) {
            i = R.string.scope_email;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Connections.INSTANCE)) {
            i = R.string.scope_connections;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Guilds.INSTANCE)) {
            i = R.string.scope_guilds;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.GuildsJoin.INSTANCE)) {
            i = R.string.scope_guilds_join;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.GuildsMembersRead.INSTANCE)) {
            i = R.string.scope_guilds_members_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.GdmJoin.INSTANCE)) {
            i = R.string.scope_gdm_join;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Bot.INSTANCE)) {
            i = R.string.scope_bot;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.WebhookIncoming.INSTANCE)) {
            i = R.string.scope_webhook_incoming;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Rpc.INSTANCE)) {
            i = R.string.scope_rpc;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RpcNotificationsRead.INSTANCE)) {
            i = R.string.scope_rpc_notifications_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RpcVoiceRead.INSTANCE)) {
            i = R.string.scope_rpc_voice_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RpcVoiceWrite.INSTANCE)) {
            i = R.string.scope_rpc_voice_write;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RpcActivitiesWrite.INSTANCE)) {
            i = R.string.scope_rpc_activities_write;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.MessagesRead.INSTANCE)) {
            i = R.string.scope_messages_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsBuildsUpload.INSTANCE)) {
            i = R.string.scope_applications_builds_upload;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsBuildsRead.INSTANCE)) {
            i = R.string.scope_applications_builds_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsCommands.INSTANCE)) {
            i = R.string.scope_applications_commands;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsCommandsUpdate.INSTANCE)) {
            i = R.string.scope_applications_commands_update;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsStoreUpdate.INSTANCE)) {
            i = R.string.scope_applications_store_update;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ApplicationsEntitlements.INSTANCE)) {
            i = R.string.scope_applications_entitlements;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ActivitiesRead.INSTANCE)) {
            i = R.string.scope_activities_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.ActivitiesWrite.INSTANCE)) {
            i = R.string.scope_activities_write;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.RelationshipsRead.INSTANCE)) {
            i = R.string.scope_relationships_read;
        } else if (Intrinsics3.areEqual(oAuthScope, OAuthScope.Voice.INSTANCE)) {
            i = R.string.scope_voice;
        } else {
            if (!Intrinsics3.areEqual(oAuthScope, OAuthScope.DMChannelsRead.INSTANCE)) {
                if (!(oAuthScope instanceof OAuthScope.Invalid)) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new InvalidScopeException(((OAuthScope.Invalid) oAuthScope).getRawValue());
            }
            i = R.string.scope_dm_channels_read;
        }
        textView.setText(i);
    }
}
