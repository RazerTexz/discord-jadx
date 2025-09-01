package com.discord.widgets.chat.input.applicationcommands;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.models.commands.Application;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* compiled from: SelectedApplicationCommandAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u00103\u001a\u000202\u0012\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030(¢\u0006\u0004\b4\u00105J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0010J+\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u0005J/\u0010 \u001a\u00020\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u001c0\u001b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u001e¢\u0006\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010&\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u00150$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R%\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030(8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101¨\u00066"}, d2 = {"Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandAdapter;", "Lcom/discord/utilities/mg_recycler/MGRecyclerAdapterSimple;", "Lcom/discord/widgets/chat/input/applicationcommands/SelectedApplicationCommandItem;", "", "configureVerified", "()V", "Lcom/discord/models/commands/ApplicationCommand;", "command", "Lcom/discord/models/commands/Application;", "application", "setApplicationCommand", "(Lcom/discord/models/commands/ApplicationCommand;Lcom/discord/models/commands/Application;)V", "clear", "Lcom/discord/models/commands/ApplicationCommandOption;", "commandOption", "highlightOption", "(Lcom/discord/models/commands/ApplicationCommandOption;)V", "option", "onParamClicked", "Landroid/view/ViewGroup;", "parent", "", "viewType", "Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/discord/utilities/mg_recycler/MGRecyclerViewHolder;", "clearParamOptionHighlight", "", "", "verifiedInputs", "", "showOptionErrorSet", "setVerified", "(Ljava/util/Map;Ljava/util/Set;)V", "currentCommand", "Lcom/discord/models/commands/ApplicationCommand;", "", "", "paramPositions", "Ljava/util/Map;", "Lkotlin/Function1;", "onClickApplicationCommandOption", "Lkotlin/jvm/functions/Function1;", "getOnClickApplicationCommandOption", "()Lkotlin/jvm/functions/Function1;", "highlightedCommandOption", "Lcom/discord/models/commands/ApplicationCommandOption;", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "scroller", "Landroidx/recyclerview/widget/RecyclerView$SmoothScroller;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lkotlin/jvm/functions/Function1;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class SelectedApplicationCommandAdapter extends MGRecyclerAdapterSimple<SelectedApplicationCommandAdapter8> {
    private ApplicationCommand currentCommand;
    private ApplicationCommandOption highlightedCommandOption;
    private final Function1<ApplicationCommandOption, Unit> onClickApplicationCommandOption;
    private final Map<String, Integer> paramPositions;
    private RecyclerView.SmoothScroller scroller;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectedApplicationCommandAdapter(RecyclerView recyclerView, Function1<? super ApplicationCommandOption, Unit> function1) {
        super(recyclerView, false);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics3.checkNotNullParameter(function1, "onClickApplicationCommandOption");
        this.onClickApplicationCommandOption = function1;
        this.paramPositions = new LinkedHashMap();
        this.scroller = new SelectedApplicationCommandAdapter7(this, getContext());
    }

    public static final /* synthetic */ RecyclerView.SmoothScroller access$getScroller$p(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter) {
        return selectedApplicationCommandAdapter.scroller;
    }

    public static final /* synthetic */ void access$setScroller$p(SelectedApplicationCommandAdapter selectedApplicationCommandAdapter, RecyclerView.SmoothScroller smoothScroller) {
        selectedApplicationCommandAdapter.scroller = smoothScroller;
    }

    private final void configureVerified() {
    }

    public final void clear() {
        setData(Collections2.emptyList());
        this.paramPositions.clear();
        this.currentCommand = null;
        this.highlightedCommandOption = null;
    }

    public final void clearParamOptionHighlight() {
        if (getItemCount() == 0) {
            return;
        }
        Map<String, Integer> map = this.paramPositions;
        ApplicationCommandOption applicationCommandOption = this.highlightedCommandOption;
        Integer num = map.get(applicationCommandOption != null ? applicationCommandOption.getName() : null);
        if (num != null) {
            int iIntValue = num.intValue();
            getItem(iIntValue).setHighlighted(false);
            notifyItemChanged(iIntValue);
        }
    }

    public final Function1<ApplicationCommandOption, Unit> getOnClickApplicationCommandOption() {
        return this.onClickApplicationCommandOption;
    }

    public final void highlightOption(ApplicationCommandOption commandOption) {
        Integer num;
        Intrinsics3.checkNotNullParameter(commandOption, "commandOption");
        if (Intrinsics3.areEqual(this.highlightedCommandOption, commandOption)) {
            return;
        }
        clearParamOptionHighlight();
        this.highlightedCommandOption = commandOption;
        if (getItemCount() == 0 || (num = this.paramPositions.get(commandOption.getName())) == null) {
            return;
        }
        int iIntValue = num.intValue();
        this.highlightedCommandOption = commandOption;
        getItem(iIntValue).setHighlighted(true);
        notifyItemChanged(iIntValue);
        getRecycler().post(new SelectedApplicationCommandAdapter6(iIntValue, this, commandOption));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void onParamClicked(ApplicationCommandOption option) {
        Intrinsics3.checkNotNullParameter(option, "option");
        this.onClickApplicationCommandOption.invoke(option);
    }

    public final void setApplicationCommand(ApplicationCommand command, Application application) {
        Intrinsics3.checkNotNullParameter(command, "command");
        Intrinsics3.checkNotNullParameter(application, "application");
        ApplicationCommand applicationCommand = this.currentCommand;
        if (Intrinsics3.areEqual(applicationCommand != null ? applicationCommand.getId() : null, command.getId())) {
            return;
        }
        this.currentCommand = command;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SelectedApplicationCommandAdapter8(application, null, false, false, false, command.getName(), null, 94, null));
        List<ApplicationCommandOption> options = command.getOptions();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : options) {
            if (((ApplicationCommandOption) obj).getRequired()) {
                arrayList2.add(obj);
            }
        }
        int i = 0;
        int i2 = 0;
        for (Object obj2 : arrayList2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                Collections2.throwIndexOverflow();
            }
            ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) obj2;
            this.paramPositions.put(applicationCommandOption.getName(), Integer.valueOf(arrayList.size()));
            arrayList.add(new SelectedApplicationCommandAdapter8(null, applicationCommandOption, false, false, false, null, null, Opcodes.LUSHR, null));
            i2 = i3;
        }
        List<ApplicationCommandOption> options2 = command.getOptions();
        if (!(options2 instanceof Collection) || !options2.isEmpty()) {
            Iterator<T> it = options2.iterator();
            while (it.hasNext()) {
                if ((!((ApplicationCommandOption) it.next()).getRequired()) && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        if (i != 0) {
            arrayList.add(new SelectedApplicationCommandAdapter8(null, null, false, false, false, null, getRecycler().getResources().getString(R.string.commands_optional_header), 63, null));
        }
        List<ApplicationCommandOption> options3 = command.getOptions();
        ArrayList<ApplicationCommandOption> arrayList3 = new ArrayList();
        for (Object obj3 : options3) {
            if (!((ApplicationCommandOption) obj3).getRequired()) {
                arrayList3.add(obj3);
            }
        }
        for (ApplicationCommandOption applicationCommandOption2 : arrayList3) {
            this.paramPositions.put(applicationCommandOption2.getName(), Integer.valueOf(arrayList.size()));
            arrayList.add(new SelectedApplicationCommandAdapter8(null, applicationCommandOption2, false, false, false, null, null, Opcodes.LUSHR, null));
        }
        setData(arrayList);
    }

    public final void setVerified(Map<ApplicationCommandOption, Boolean> verifiedInputs, Set<ApplicationCommandOption> showOptionErrorSet) {
        Intrinsics3.checkNotNullParameter(verifiedInputs, "verifiedInputs");
        Intrinsics3.checkNotNullParameter(showOptionErrorSet, "showOptionErrorSet");
        if (getItemCount() == 0) {
            return;
        }
        for (ApplicationCommandOption applicationCommandOption : verifiedInputs.keySet()) {
            Integer num = this.paramPositions.get(applicationCommandOption.getName());
            if (num != null) {
                int iIntValue = num.intValue();
                getItem(iIntValue).setCompleted(Intrinsics3.areEqual(verifiedInputs.get(applicationCommandOption), Boolean.TRUE));
                getItem(iIntValue).setError(showOptionErrorSet.contains(applicationCommandOption));
            }
        }
        configureVerified();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<SelectedApplicationCommandAdapter, SelectedApplicationCommandAdapter8> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new SelectedApplicationCommandAdapter5(this);
        }
        if (viewType == 1) {
            return new SelectedApplicationCommandAdapter2(this);
        }
        if (viewType == 2) {
            return new SelectedApplicationCommandAdapter4(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
