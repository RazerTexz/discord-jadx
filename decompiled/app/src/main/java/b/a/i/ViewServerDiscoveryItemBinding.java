package b.a.i;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.viewbinding.ViewBinding;
import com.discord.views.GuildView;
import com.discord.views.guilds.ServerMemberCount;
import com.google.android.material.button.MaterialButton;

/* compiled from: ViewServerDiscoveryItemBinding.java */
/* renamed from: b.a.i.g3, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewServerDiscoveryItemBinding implements ViewBinding {

    @NonNull
    public final View a;

    /* renamed from: b, reason: collision with root package name */
    @NonNull
    public final MaterialButton f119b;

    @NonNull
    public final MaterialButton c;

    @NonNull
    public final ServerMemberCount d;

    @NonNull
    public final TextView e;

    @NonNull
    public final GuildView f;

    @NonNull
    public final TextView g;

    public ViewServerDiscoveryItemBinding(@NonNull View view, @NonNull Barrier barrier, @NonNull Barrier barrier2, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull ServerMemberCount serverMemberCount, @NonNull TextView textView, @NonNull GuildView guildView, @NonNull TextView textView2) {
        this.a = view;
        this.f119b = materialButton;
        this.c = materialButton2;
        this.d = serverMemberCount;
        this.e = textView;
        this.f = guildView;
        this.g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
