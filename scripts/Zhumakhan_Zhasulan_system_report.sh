#!/bin/bash
LOG=~/zhumakhan_zhasulan-student-api/logs/Zhumakhan_Zhasulan_system_report.log
{
echo "=== System report: Zhumakhan Zhasulan ==="
echo "Date: $(date)"
echo "User: $(whoami)"
echo "OS: $(grep PRETTY_NAME /etc/os-release | cut -d= -f2)"
echo "Kernel: $(uname -r)"
echo "CPU: $(nproc) cores"
free -h
df -h /
} >> "$LOG"
echo "Report saved to $LOG"

