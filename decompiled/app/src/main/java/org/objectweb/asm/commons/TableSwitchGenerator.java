package org.objectweb.asm.commons;

import org.objectweb.asm.Label;

/* loaded from: discord:org/objectweb/asm/commons/TableSwitchGenerator.SCL.lombok */
public interface TableSwitchGenerator {
    void generateCase(int i, Label label);

    void generateDefault();
}
